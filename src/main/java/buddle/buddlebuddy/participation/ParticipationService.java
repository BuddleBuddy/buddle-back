package buddle.buddlebuddy.participation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipationService {
    private final ParticipationRepository participationRepository;

    public ParticipationService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public void createParticipation(){
        Participation part = new Participation();
        participationRepository.save(part);
    }

    public Long getParticipation(){
        Long aLong = participationRepository.countBy();
        return aLong;
    }
}
