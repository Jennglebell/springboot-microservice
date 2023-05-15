package net.jengglebell.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import net.jengglebell.organizationservice.dto.OrganizationDto;
import net.jengglebell.organizationservice.entity.Organization;
import net.jengglebell.organizationservice.mapper.OrganizationMapper;
import net.jengglebell.organizationservice.repository.OrganizationRepository;
import net.jengglebell.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
