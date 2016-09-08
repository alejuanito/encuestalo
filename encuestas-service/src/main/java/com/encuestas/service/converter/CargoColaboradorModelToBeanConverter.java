package com.encuestas.service.converter;

import com.encuestas.data.bean.CargoColaboradorBean;
import com.encuestas.data.model.CargoColaborador;

public class CargoColaboradorModelToBeanConverter extends AbstractDataConverter<CargoColaborador, CargoColaboradorBean> {

    @Override
    public CargoColaboradorBean convert(CargoColaborador cargoColaborador) {
        if (cargoColaborador == null) {
            return null;
        }
        CargoColaboradorBean cargoColaboradorBean = new CargoColaboradorBean();
        cargoColaboradorBean.setCoCargoColaborador(cargoColaborador.getCoCargoColaborador());
        cargoColaboradorBean.setDeCargoColaborador(cargoColaborador.getDeCargoColaborador());
        return cargoColaboradorBean;
    }

}
