package Items.item02.Service;

import Items.item02.Bean.City;
import Items.item02.Bean.Province;
import Items.item02.Dao.CityDao;
import Items.item02.Dao.ProvinceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceCityServiceImpl implements ProvinceCityService {
    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private CityDao cityDao;

    @Override
    public List<Province> queryAllProvince() {
        return provinceDao.selectProvinceList();
    }

    @Override
    public int addCity(City city) {
        int rows = cityDao.insertCity(city);
        return rows;
    }

    @Override
    public List<City> queryCityByProvinceId(Integer provinceId) {
        return cityDao.selectCityByProvinceId(provinceId);
    }
}
