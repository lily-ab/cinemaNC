package com.lab4nc.cinema.BLL.Services;

import com.lab4nc.cinema.DAL.Entities.RawEntity;
import com.lab4nc.cinema.DAL.Models.HallSchemaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RawService {
    List<RawEntity> getRaws(int id);
}
