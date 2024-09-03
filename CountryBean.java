import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class CountryBean {

    private List<Country> countryList;
    private Country selectedCountry;

    // Inject the service
    private CountryService countryService;

    // Getter for countryList
    public List<Country> getCountryList() {
        if (countryList == null) {
            countryList = countryService.findAllCountries();
        }
        return countryList;
    }

    // Action method for viewing a country's details
    public String viewCountry(int countryId) {
        selectedCountry = countryService.findCountryById(countryId);
        return "country?faces-redirect=true";
    }

    // Getter for selectedCountry
    public Country getSelectedCountry() {
        return selectedCountry;
    }
}
