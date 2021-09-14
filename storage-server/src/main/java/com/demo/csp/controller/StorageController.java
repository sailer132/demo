package com.demo.csp.controller;


import com.demo.csp.entity.CommonResult;
import com.demo.csp.entity.Storage;
import com.demo.csp.repository.StorageRepository;
import com.demo.csp.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/9/7 9:58
 * @Created by Wu Zhi Qiang
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Storage addStorage(){

        Storage storage = new Storage();
        storage.setProductId(1L);
        storage.setTotal(1000L);
        storage.setUsed(0L);
        storage.setResidue(1000L);
        Storage save = storageRepository.save(storage);
        return save;
    }

    @RequestMapping(value = "/getByStorageId",method = RequestMethod.GET)
    public Storage getStorageById(String id){

        Storage storage = storageRepository.getOne(1L);
        return storage;
    }

    @PostMapping("/decrease")
    public CommonResult decrease(Long productId, Long count) {

        Storage storage = new Storage();
        storage.setProductId(1L);
        storage.setTotal(1000L);
        storage.setUsed(0L);
        storage.setResidue(1000L);
        Storage save = storageRepository.save(storage);

        return storageService.decrease(productId, count);
    }

}
