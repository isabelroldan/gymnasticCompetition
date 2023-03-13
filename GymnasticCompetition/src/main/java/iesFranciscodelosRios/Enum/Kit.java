package iesFranciscodelosRios.Enum;

public enum Kit {
	HOOP,
	MACES,
	RIBBON,
	ROPE,
	HANDSFREE;
	
	/**
     * Este metodo comprobara que el nombre introducido por el usuario sea igual que alguno de los Enumeradores ya
     * predefinidos
     * @param name nombre del tipo introducido por el usuario
     * @return devuelve el Enum si lo ha encontrado. si no devuelvo Null
     */
    public Kit fromName(String name){
        for (Kit e: Kit.values()){
            if(e.name().equalsIgnoreCase(name)){
                return e;
            }
        }
        return null;
    }
}
