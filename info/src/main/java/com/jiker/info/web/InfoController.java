package com.jiker.info.web;

import com.jiker.info.dao.domain.MusicInfo;
import com.jiker.info.service.MusicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class InfoController {

    private static final String INDEX = "index";
    @Autowired
    private MusicInfoService musicInfoService;

    @RequestMapping("/show")
    public String getIndex() {
        return INDEX;
    }

    @RequestMapping("/music/info")
    @ResponseBody
    public List<MusicInfo> getMusicInfo(MusicInfo musicInfo) {
        List<MusicInfo> musicInfoList = musicInfoService.getMusicInfo(null);
        //System.out.println("musicInfoList size="+musicInfoList.size());
        return musicInfoList;
    }
    @RequestMapping("/music/del")
    @ResponseBody
    public int deleteMusicInfo() {
        int res = musicInfoService.deleteMusicInfo();
        return res;
    }
}
