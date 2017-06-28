package com.spicejet.constants;

public enum Browsers {
	CH,
	FF,
	IE,
	SF,
	OP,
	HD;
	public static Browsers browserForName(String browser)
	{
		for(Browsers b:Browsers.values())
		{
			if(browser.equalsIgnoreCase(b.toString()))
			{
				return b;
			}
		}
		return null;
	}

}
