package ru.rkondako.course_work.dto;

import java.io.Serial;
import java.io.Serializable;

public class MedicalThingInfo implements Serializable {
	@Serial
	private static final long serialVersionUID = 101L;

	private String name;
	private Integer consultationPrice;
	private Integer treatmentPrice;

	public MedicalThingInfo() {
	}

	public String getName() {
		return this.name;
	}

	public Integer getConsultationPrice() {
		return this.consultationPrice;
	}

	public Integer getTreatmentPrice() {
		return this.treatmentPrice;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setConsultationPrice(Integer consultationPrice) {
		this.consultationPrice = consultationPrice;
	}

	public void setTreatmentPrice(Integer treatmentPrice) {
		this.treatmentPrice = treatmentPrice;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof MedicalThingInfo)) return false;
		final MedicalThingInfo other = (MedicalThingInfo) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$name = this.getName();
		final Object other$name = other.getName();
		if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
		final Object this$consultationPrice = this.getConsultationPrice();
		final Object other$consultationPrice = other.getConsultationPrice();
		if (this$consultationPrice == null ? other$consultationPrice != null : !this$consultationPrice.equals(other$consultationPrice))
			return false;
		final Object this$treatmentPrice = this.getTreatmentPrice();
		final Object other$treatmentPrice = other.getTreatmentPrice();
		if (this$treatmentPrice == null ? other$treatmentPrice != null : !this$treatmentPrice.equals(other$treatmentPrice))
			return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof MedicalThingInfo;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $name = this.getName();
		result = result * PRIME + ($name == null ? 43 : $name.hashCode());
		final Object $consultationPrice = this.getConsultationPrice();
		result = result * PRIME + ($consultationPrice == null ? 43 : $consultationPrice.hashCode());
		final Object $treatmentPrice = this.getTreatmentPrice();
		result = result * PRIME + ($treatmentPrice == null ? 43 : $treatmentPrice.hashCode());
		return result;
	}

	public String toString() {
		return "MedicalThingInfo(name=" + this.getName() + ", consultationPrice=" + this.getConsultationPrice() + ", treatmentPrice=" + this.getTreatmentPrice() + ")";
	}
}
