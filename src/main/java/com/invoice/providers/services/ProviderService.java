package com.invoice.providers.services;

import com.invoice.providers.ProviderDTO;
import com.invoice.providers.ProviderExternalAPI;
import com.invoice.providers.mappers.ProviderMapper;
import com.invoice.providers.models.Provider;
import com.invoice.providers.repositories.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProviderService implements ProviderExternalAPI {
    private ProviderRepository providerRepository;
    private ProviderMapper providerMapper;
    @Override
    public ProviderDTO getProviderById(Long id) {
        return providerMapper.providerToProviderDTO(providerRepository.findById(id).orElseThrow(()->new NoSuchElementException("")));
    }

    @Override
    public List<ProviderDTO> getAllProvider() {
        return providerRepository.findAll()
                .stream()
                .map(provider -> providerMapper.providerToProviderDTO(provider))
                .toList();
    }

    @Override
    public ProviderDTO saveProvider(ProviderDTO providerDTO) {
        return providerMapper.providerToProviderDTO(providerRepository.save(providerMapper.ProviderDTOToProvider(providerDTO)));
    }

    @Override
    public ProviderDTO updateProvider(Long id, ProviderDTO providerDTO) {
        Provider provider = providerMapper.ProviderDTOToProvider(getProviderById(id));
        provider.setName(providerDTO.name());
        provider.setDescription(providerDTO.description());
        return providerMapper.providerToProviderDTO(providerRepository.save(provider));
    }

    @Override
    public ProviderDTO deleteProvider(Long id) {
        Provider provider = providerMapper.ProviderDTOToProvider(getProviderById(id));
        ProviderDTO providerDTO = providerMapper.providerToProviderDTO(provider);
        providerRepository.delete(provider);
        return providerDTO;
    }
}
