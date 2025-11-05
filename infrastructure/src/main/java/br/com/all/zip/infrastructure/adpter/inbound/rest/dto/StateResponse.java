package br.com.all.zip.infrastructure.adpter.inbound.rest.dto;

public record StateResponse(
        Integer id,
        String name,
        String initials
) {}
