package com.skripsi.innasya.optscan.Model;

import java.util.HashMap;
import java.util.Map;

public class Pestisida {

private String id;
private String optId;
private String merekDagang;
private String bahanAktif;
private String caraKerja;
private String bahayaPestisida;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getOptId() {
return optId;
}

public void setOptId(String optId) {
this.optId = optId;
}

public String getMerekDagang() {
return merekDagang;
}

public void setMerekDagang(String merekDagang) {
this.merekDagang = merekDagang;
}

public String getBahanAktif() {
return bahanAktif;
}

public void setBahanAktif(String bahanAktif) {
this.bahanAktif = bahanAktif;
}

public String getCaraKerja() {
return caraKerja;
}

public void setCaraKerja(String caraKerja) {
this.caraKerja = caraKerja;
}

public String getBahayaPestisida() {
return bahayaPestisida;
}

public void setBahayaPestisida(String bahayaPestisida) {
this.bahayaPestisida = bahayaPestisida;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}