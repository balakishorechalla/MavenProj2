package com.spicejet.constants;

public enum Keyss {
	ENTER,
	TAB;
	public static Keyss keyForName(String keyNm)
	{
		for(Keyss k:Keyss.values())
		{
			if(keyNm.equalsIgnoreCase(k.toString()))
			{
				return k;
			}
		}
		return null;
	}

}
