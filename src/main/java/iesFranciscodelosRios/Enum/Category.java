package iesFranciscodelosRios.Enum;

public enum Category {
	PREBENJAMIN,
    BENJAMIN,
    ALEVIN,
    INFANTIL,
    JUNIOR,
    SENIOR;
    
    /**
     * Este metodo comprobara que el nombre introducido por el usuario sea igual que alguno de los Enumeradores ya
     * predefinidos
     * @param name nombre del tipo introducido por el usuario
     * @return devuelve el Enum si lo ha encontrado. si no devuelvo Null
     */
    public static Category fromName(String name){
        for (Category e: Category.values()){
            if(e.name().equalsIgnoreCase(name)){
                return e;
            }
        }
        return null;
    }
}
