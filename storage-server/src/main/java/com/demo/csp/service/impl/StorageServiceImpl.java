package com.demo.csp.service.impl;

import com.demo.csp.entity.CommonResult;
import com.demo.csp.entity.Storage;
import com.demo.csp.entity.SystemCode;
import com.demo.csp.repository.StorageRepository;
import com.demo.csp.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author clay
 * @version 1.0
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageRepository storageRepository;

    public CommonResult decrease(Long productId, Long count) {
        Storage storage = storageRepository.getOne(1L);
        Long total = storage.getTotal();
        Long used = storage.getUsed();
        Long residue = storage.getResidue();
        // 校验参数
        if (count == null || count <= 0) {
            return new CommonResult(SystemCode.ERROR_PARAMETER);
        }
        // 判断库存是否足够
        if (count > residue) {
            return new CommonResult(SystemCode.STORAGE_NOT_ENOUGH);
        }
        // 扣减库存
        storage.setUsed(used + count);
        storage.setResidue(residue - count);
        storageRepository.save(storage);
        return new CommonResult();
    }
}
