package Items.item02.Controller;

import Items.item02.Bean.City;
import Items.item02.Bean.Province;
import Items.item02.Service.ProvinceCityService;
import Items.item02.VO.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//返回值如果为
@Controller
public class ProvinceCityController {
    @Autowired
    private ProvinceCityService service;

    //查询所有的省份
    @RequestMapping("/queryProvince.do")
    @ResponseBody
    public CommonResult queryProvinces() {
        List<Province> list = service.queryAllProvince();
        CommonResult cr = new CommonResult(0, "查询没有结果", "");
        if (list != null && list.size() > 0) {
            cr = new CommonResult(1, "查询成功", list);
        }
        return cr;
    }

    //添加城市
    @RequestMapping("/city/addCity.do")
    @ResponseBody
    public CommonResult addCity(City city) {
        int rows = 0;
        if (!city.getName().equals("") && city.getName() != null) {
            rows = service.addCity(city);
        }

        CommonResult cr = new CommonResult(0, "添加城市失败", "");
        if (rows > 0) {
            cr = new CommonResult(1, "添加城市" + city.getName() + "成功", city);
        } else {
            cr = new CommonResult(0, "添加城市失败", "");
        }
        return cr;
    }


    //查询城市
    @RequestMapping("/city/queryCity.do")
    @ResponseBody
    public CommonResult queryCity(Integer pid) {
        List<City> citylist = service.queryCityByProvinceId(pid);
        CommonResult cr = new CommonResult(0, "查询无结果", "");
        if (citylist != null && citylist.size() > 0) {
            cr = new CommonResult(1, "查询出" + citylist.size() + "个城市", citylist);
        }
        return cr;
    }

}
