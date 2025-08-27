package br.com.erudio.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault(); //mapeia entidade para DTO e vice-versa

    public static <O, D> D parseObject(O origin, Class<D> destination){ //metodo generico
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination){ //metodo generico

        List<D> destinationObjects = new ArrayList<D>();

        for (Object o : origin){
            //var b = mapper.map(o, destination);
            destinationObjects.add(mapper.map(o, destination));
        }

        return destinationObjects;
    }
}
