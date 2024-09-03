import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class EmissionBean {

    private List<Emission> emissionList;

    // Inject the service
    private EmissionService emissionService;

    // Getter for emissionList
    public List<Emission> getEmissionList() {
        if (emissionList == null) {
            // Assuming selectedCountry is available from CountryBean
            emissionList = emissionService.findEmissionsByCountryId(CountryBean.getSelectedCountry().getId());
        }
        return emissionList;
    }
}
