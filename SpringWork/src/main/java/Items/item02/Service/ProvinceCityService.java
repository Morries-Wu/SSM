package Items.item02.Service;

import Items.item02.Bean.City;
import Items.item02.Bean.Province;

import java.util.List;

public interface ProvinceCityService {

    public List<Province> queryAllProvince();

    int addCity(City city);

    List<City> queryCityByProvinceId(Integer provinceId);
}
