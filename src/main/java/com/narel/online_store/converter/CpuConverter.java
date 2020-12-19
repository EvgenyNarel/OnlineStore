package com.narel.online_store.converter;

import com.narel.online_store.Dto.CPUDto;
import com.narel.online_store.entity.CPU;
import org.springframework.stereotype.Component;

@Component
public class CpuConverter {

    public CPU fromCPUDtoToCPU(CPUDto cpuDto){
        CPU cpu = new CPU();
        cpu.setId(cpuDto.getId());
        cpu.setCPU(cpuDto.getCpu());
        return cpu;
    }

    public CPUDto fromCPUToCPUDto(CPU cpu){
        return CPUDto.builder()
                .id(cpu.getId())
                .cpu(cpu.getCPU())
                .build();
    }
}
