package com.istudy.collection.controller;


import com.istudy.collection.pojo.Collect;
import com.istudy.collection.service.imp.CollectionImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Api(value = "收藏管理")
@Controller
@RestController
@CrossOrigin(allowCredentials="true")
public class CollectionController {
    @Autowired
    private CollectionImp collectService;

    //    添加收藏的歌曲
    @ApiOperation("添加收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "songId", value = "歌曲id", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "songListId", value = "用户id", required = true, dataType = "string", paramType = "query")
    })
    @ResponseBody
    @RequestMapping(value = "/collection/add", method = RequestMethod.POST)
    public Object addCollection(HttpServletRequest req){

        JSONObject jsonObject = new JSONObject();
        String user_id = req.getParameter("userId");
        String type = req.getParameter("type");
        String song_id=req.getParameter("songId");
        String song_list_id=req.getParameter("songListId");
        if (song_id == ""){
            jsonObject.put("code", 0);
            jsonObject.put("msg", "收藏歌曲为空");
            return jsonObject;
        } else if (collectService.existSongId(Integer.parseInt(user_id), Integer.parseInt(song_id))) {
            jsonObject.put("code", 2);
            jsonObject.put("msg", "已收藏");
            return jsonObject;
        }
        Collect collect = new Collect();
        collect.setUserId(Integer.parseInt(user_id));
        collect.setType(new Byte(type));
        if (new Byte(type) == 0) {
            collect.setSongId(Integer.parseInt(song_id));
        } else if (new Byte(type) == 1) {
            collect.setSongListId(Integer.parseInt(song_list_id));
        }
        collect.setCreateTime(new Date());
        boolean res = collectService.addCollection(collect);
        if (res){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "收藏成功");
            return jsonObject;
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "收藏失败");
            return jsonObject;
        }
    }

    //    返回所有用户收藏列表
    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public Object allCollection(){
        return collectService.allCollect();
    }

    //    返回的指定用户ID收藏列表
    @RequestMapping(value = "/collection/detail", method = RequestMethod.GET)
    public Object collectionOfUser(HttpServletRequest req){
        String userId = req.getParameter("userId");
        return collectService.collectionOfUser(Integer.parseInt(userId));
    }

    //    删除收藏的歌曲
    @RequestMapping(value = "/collection/delete", method = RequestMethod.GET)
    public Object deleteCollection(HttpServletRequest req){
        String user_id = req.getParameter("userId").trim();
        String song_id = req.getParameter("songId").trim();
        return collectService.deleteCollect(Integer.parseInt(user_id), Integer.parseInt(song_id));
    }

    //    更新收藏
    @ResponseBody
    @RequestMapping(value = "/collection/update", method = RequestMethod.POST)
    public Object updateCollectMsg(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();
        String user_id = req.getParameter("userId").trim();
        String type = req.getParameter("type").trim();
        String song_id = req.getParameter("songId").trim();
//        String song_list_id = req.getParameter("songListId").trim();

        Collect collect = new Collect();
        collect.setId(Integer.parseInt(id));
        collect.setUserId(Integer.parseInt(user_id));
        collect.setType(new Byte(type));
        collect.setSongId(Integer.parseInt(song_id));

        boolean res = collectService.updateCollectMsg(collect);
        if (res){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "修改成功");
            return jsonObject;
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "修改失败");
            return jsonObject;
        }
    }


}
