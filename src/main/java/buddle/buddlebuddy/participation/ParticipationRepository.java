package buddle.buddlebuddy.participation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository  extends JpaRepository<Participation, Long> {
    Long countBy();
}
