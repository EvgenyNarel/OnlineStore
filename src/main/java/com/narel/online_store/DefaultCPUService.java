package com.narel.online_store;

import com.narel.online_store.Dto.CPUDto;
import com.narel.online_store.MyException.ValidationException;
import com.narel.online_store.converter.CpuConverter;
import com.narel.online_store.entity.CPU;
import com.narel.online_store.repository.CPURepository;
import com.narel.online_store.service.CPUService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultCPUService implements CPUService {
    private final CPURepository cpuRepository;
    private final CpuConverter cpuConverter;


    @Override
    public CPUDto saveCpu(CPUDto cpuDto) throws ValidationException {
        validateCpuDto(cpuDto);
        CPU savedCpu = cpuRepository.save(cpuConverter.fromCPUDtoToCPU(cpuDto));
        return cpuConverter.fromCPUToCPUDto(savedCpu);
    }

    private void validateCpuDto(CPUDto cpuDto) throws ValidationException {
        if (isNull(cpuDto)) {
            throw new ValidationException("Object CPU is null");
        }
    }

    @Override
    public void deleteCPU(Long id) {
        cpuRepository.deleteById(id);
    }

    @Override
    public List<CPUDto> findAll() {
        return cpuRepository.findAll()
                .stream()
                .map(cpuConverter::fromCPUToCPUDto)
                .collect(Collectors.toList());
    }
}
