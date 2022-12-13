package com.backmantenedor.repository;


import com.backmantenedor.entity.ApiRoute;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ApiRouterRepositor {

//
//    @Autowired
//    private EntityManager emg;
//
//
//    public List<ApiRoute> dataApiRouter() throws JSONException {
//
//        JSONObject jsonObject = null;
//        List<String> listaApi = new ArrayList<>();
//
//        try {
//            jsonObject = new JSONObject((Map) dataApiRouter());
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = 0; i < jsonObject.getJSONArray("apiroute").length(); i++) {
//            listaApi.add(jsonObject.getJSONArray("apiroute").getString(i));
//        }
//
//        String query = "select  * from api_route" +
//                "          where (tipo = :dataTipo  or '9999' = :dataTipo)" +
//                "          and (method = :met or '9999' = :met);";
//
//        List<ApiRoute> respData = emg.createNativeQuery(query, ApiRoute.class)
//                .setParameter("dataTipo", "")
//                .getResultList();
//
//        return dataApiRouter();
//    }

}
