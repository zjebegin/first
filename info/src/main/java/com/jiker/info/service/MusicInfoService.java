package com.jiker.info.service;

import com.jiker.info.dao.domain.MusicInfo;

import java.util.List;

public interface MusicInfoService {
    public List<MusicInfo> getMusicInfo(MusicInfo musicInfo);
    public int deleteMusicInfo();
}
