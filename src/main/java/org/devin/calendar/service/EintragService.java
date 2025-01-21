package org.devin.calendar.service;

import org.devin.calendar.dto.EintragDTO;
import org.devin.calendar.model.Eintrag;
import org.devin.calendar.repository.EintragRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EintragService {
    private final EintragRepository eintragRepository;

    public EintragService(EintragRepository eintragRepository) {
        this.eintragRepository = eintragRepository;
    }

    public Eintrag createEintrag(EintragDTO eintragDTO) {
        validateEintrag(eintragDTO);

        Eintrag eintrag = new Eintrag(
            eintragDTO.getName(),
            eintragDTO.getInfo(),
            eintragDTO.getAbholdatum(),
            eintragDTO.getAbholzeit(),
            eintragDTO.getAbholOrt(),
            eintragDTO.getZielOrt(),
            eintragDTO.getTelefonnummer()
        );

        return eintragRepository.save(eintrag);
    }

    public Eintrag updateEintrag(Long id, EintragDTO eintragDTO) {
        validateEintrag(eintragDTO);

        Eintrag eintrag = eintragRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Eintrag not found"));
        eintrag.setName(eintragDTO.getName());
        eintrag.setInfo(eintragDTO.getInfo());
        eintrag.setAbholdatum(eintragDTO.getAbholdatum());
        eintrag.setAbholzeit(eintragDTO.getAbholzeit());
        eintrag.setAbholOrt(eintragDTO.getAbholOrt());
        eintrag.setZielOrt(eintragDTO.getZielOrt());
        eintrag.setTelefonnummer(eintragDTO.getTelefonnummer());

        return eintragRepository.save(eintrag);
    }

    private void validateEintrag(EintragDTO eintragDTO) {
        if(eintragDTO.getName() == null || eintragDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("Name darf nicht leer sein");
        }

        if(eintragDTO.getAbholdatum() == null) {
            throw new IllegalArgumentException("Abholdatum darf nicht leer sein");
        }

        if(eintragDTO.getAbholOrt() == null || eintragDTO.getAbholOrt().isEmpty()) {
            throw new IllegalArgumentException("Abholort darf nicht leer sein");
        }

        if(eintragDTO.getZielOrt() == null || eintragDTO.getZielOrt().isEmpty()) {
            throw new IllegalArgumentException("Zielort darf nicht leer sein");
        }

        if(eintragDTO.getTelefonnummer() == null || eintragDTO.getTelefonnummer().isEmpty()) {
            throw new IllegalArgumentException("Telefonnummer darf nicht leer sein");
        }

        if(eintragDTO.getAbholdatum().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Abholdatum darf nicht in der Vergangenheit liegen");
        }

        if(eintragDTO.getAbholzeit() == null) {
            throw new IllegalArgumentException("Abholzeit darf nicht leer sein");
        }

    }
}
