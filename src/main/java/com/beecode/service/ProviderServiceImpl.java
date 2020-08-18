package com.beecode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beecode.entity.Provider;
import com.beecode.interfaces.ProviderService;
import com.beecode.repository.IProviderRepository;

@Service
public class ProviderServiceImpl implements ProviderService {
	
	@Autowired
	private IProviderRepository providerRepo;

	@Override
	public Provider createProvider(Provider provider) {
		return providerRepo.save(provider);
	}

	@Override
	public Provider updateProvider(Provider provider) {
		return providerRepo.save(provider);
	}

	@Override
	public Provider getProviderById(Long id) {
		Optional<Provider> optionalProvider = providerRepo.findById(id);
		if(optionalProvider.isPresent()) {
			return optionalProvider.get();
		}else {
			return null;
		}
	}

	@Override
	public void deleteProvider(Long id) {
		providerRepo.deleteById(id);
	}

	@Override
	public List<Provider> getAllProvider() {
		return providerRepo.findAll();
	}

}
