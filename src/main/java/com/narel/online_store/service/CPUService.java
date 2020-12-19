package com.narel.online_store.service;

import com.narel.online_store.Dto.CPUDto;
import com.narel.online_store.MyException.ValidationException;

import java.util.List;

public interface CPUService {
    CPUDto saveCpu(CPUDto cpuDto) throws ValidationException;

    void deleteCPU(Long id);

    List<CPUDto> findAll();
}
