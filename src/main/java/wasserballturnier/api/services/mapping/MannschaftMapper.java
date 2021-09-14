package wasserballturnier.api.services.mapping;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import wasserballturnier.api.generated.model.MannschaftPushTO;
import wasserballturnier.api.persistence.mannschaft.Mannschaft;
import wasserballturnier.api.persistence.mannschaft.MannschaftRepository;

@Mapper(componentModel = "spring")
public abstract class MannschaftMapper {

    @Autowired
    MannschaftRepository mannschaftRepository;

    public abstract Mannschaft entityFromPushTO(final MannschaftPushTO mannschaftPushTO);
}
