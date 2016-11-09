package search.codekon.de.search.utils;


public class City {

    private String city;
    private String areaCode;

    /**
     * Constructor
     *
     * @param city
     * @param areaCode
     */
    public City(String city, String areaCode){
        this.city = city;
        this.areaCode = areaCode;
    }

    /**
     * Get city name
     *
     * @return
     */
    public String getCity(){
        return city;
    }

    /**
     * Get area code
     *
     * @return
     */
    public String getAreaCode(){
        return areaCode;
    }
}
