package wasserballturnier.api.services.mapping;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import wasserballturnier.api.generated.model.SpielTO;
import wasserballturnier.api.persistence.spiel.Spiel;
import wasserballturnier.api.persistence.spiel.SpielRepository;

@Mapper(componentModel = "spring")
public abstract class SpieleMapper {

    @Autowired
    SpielRepository spielRepository;

    public abstract Spiel entityFromTO(final SpielTO spielTO);
}
