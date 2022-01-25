package com.nttdata.bootcamp.product.util;

public class Constants {
    public final static String MAIN_PATH = "/product";
    public final static String ID = "/{id}";


    public final static String SAVE_VALUE="Metodo a traves del cual se envia la informacion del producto que  sera registrado dentro de la base de datos.";
    public final static String SAVE_NOTE="Para el registro del producto , sera necesario el llenado de todo los campos , a excepcion de los Id´s los cuales seran generados automaticamente.";

    public final static String GETDATA_VALUE="Metodo a traves del cual se Obtiene la informacion de todos los Productos registrados.";
    public final static String GETDATA_NOTE="Para la obtencion de todos los registros del de los Productos , solo se debe enviar la consulta.";

    public final static String GET_ID_VALUE="Metodo a traves del cual se Obtiene la informacion del Producto registrados su Id ";
    public final static String GET_ID_NOTE="Para la obtencion de datos de un  Producto , sera necesario enviar el Id del Producto a consultar";

    public final static String UPDATE_ID_VALUE="Metodo a traves del cual se Actualiza la informacion del Producto mediante su Id ";
    public final static String UPDATE_ID_NOTE="Para Actualizar los  datos del Producto , sera necesario enviar todo el registro con los datos ya actualizados junto a sus Id`s ";

    public final static String DELETE_ID_VALUE="Metodo a traves del cual se Elimina la informacion del Producto mediante su Id ";
    public final static String DELETE_ID_NOTE="Para eliminar los  datos de un Producto , sera necesario enviar el Id de la Producto ";

}
