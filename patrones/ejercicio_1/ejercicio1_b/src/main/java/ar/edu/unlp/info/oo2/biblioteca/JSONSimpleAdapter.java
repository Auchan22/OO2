package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONSimpleAdapter extends VoorheesExporter {
	
	private Object crearJSON(Socio socio) {
		JSONObject object = new JSONObject();
		object.put("nombre", socio.getNombre());
		object.put("email", socio.getEmail());
		object.put("legajo", socio.getLegajo());
		
		return object;
	}

	@Override
	public String exportar(List<Socio> socios) {
		JSONArray array = new JSONArray();
		socios.stream().forEach(s -> array.add(this.crearJSON(s)));
		return array.toJSONString();
	}
}
