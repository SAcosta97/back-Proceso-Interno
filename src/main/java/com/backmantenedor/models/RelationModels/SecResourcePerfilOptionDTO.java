package com.backmantenedor.models.RelationModels;

import com.backmantenedor.Util.GetOptionDTO;

import java.util.List;

public class SecResourcePerfilOptionDTO {

  List<GetOptionDTO> eventApi;

  List<GetOptionDTO>  eventNotApi;


    public List<GetOptionDTO> getEventApi() {
        return eventApi;
    }

    public void setEventApi(List<GetOptionDTO> eventApi) {
        this.eventApi = eventApi;
    }

    public List<GetOptionDTO> getEventNotApi() {
        return eventNotApi;
    }

    public void setEventNotApi(List<GetOptionDTO> eventNotApi) {
        this.eventNotApi = eventNotApi;
    }
}
