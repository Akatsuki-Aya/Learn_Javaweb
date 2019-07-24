package cn.sit.aya.service.Impl;

import cn.sit.aya.dao.Impl.ItemsDaoImpl;
import cn.sit.aya.dao.ItemsDao;
import cn.sit.aya.domain.Items;
import cn.sit.aya.service.ItemsService;

import java.util.List;

public class ItemsServiceImpl implements ItemsService {
    private ItemsDao dao = new ItemsDaoImpl();
    @Override
    public List<Items> findAll() {
        return dao.findAll();
    }
}
