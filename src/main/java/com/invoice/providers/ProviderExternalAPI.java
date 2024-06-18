package com.invoice.providers;

import java.util.List;

public interface ProviderExternalAPI {
    ProviderDTO getProviderById(Long id);
    List<ProviderDTO> getAllProvider();
    ProviderDTO saveProvider(ProviderDTO providerDTO);

    ProviderDTO updateProvider(Long id, ProviderDTO providerDTO);

    ProviderDTO deleteProvider(Long id);
}
