package tn.esprit.reclamemanagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.reclamemanagment.repository.Reclamation;
import tn.esprit.reclamemanagment.exception.ResourceNotFoundException;
import tn.esprit.reclamemanagment.repository.ReclamationRepository;

import java.util.List;

@Service
public class ReclamationService {
    private final ReclamationRepository reclamationRepository;

    @Autowired
    public ReclamationService(ReclamationRepository reclamationRepository) {
        this.reclamationRepository = reclamationRepository;
    }

    public Reclamation createReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    public Reclamation getReclamationById(Long id) {
        return reclamationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reclamation", "id", id));
    }

    public Reclamation updateReclamation(Long id, Reclamation updatedReclamation) {
        Reclamation reclamation = reclamationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reclamation", "id", id));

        reclamation.setTitle(updatedReclamation.getTitle());
        reclamation.setDescription(updatedReclamation.getDescription());
        reclamation.setUsername(updatedReclamation.getUsername());
        reclamation.setDate(updatedReclamation.getDate());
        reclamation.setStatus(updatedReclamation.getStatus());

        return reclamationRepository.save(reclamation);
    }

    public void deleteReclamation(Long id) {
        Reclamation reclamation = reclamationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reclamation", "id", id));

        reclamationRepository.delete(reclamation);
    }
}

