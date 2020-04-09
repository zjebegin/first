package com.jiker.info.service.impl;

import com.jiker.info.dao.domain.MusicInfo;
import com.jiker.info.dao.mapper.MusicInfoMapper;
import com.jiker.info.service.MusicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicInfoServiceImpl implements MusicInfoService {
    @Autowired
    private MusicInfoMapper musicInfoMapper;

    @Override
    public List<MusicInfo> getMusicInfo(MusicInfo musicInfo) {
        List<MusicInfo> musicInfos = musicInfoMapper.selectAll(null);
        return musicInfos;
    }
    @Override
    public int deleteMusicInfo() {
        return musicInfoMapper.deleteAll();
    }
}
