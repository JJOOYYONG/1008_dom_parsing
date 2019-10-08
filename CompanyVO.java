package com.exam;

public class CompanyVO {
	

	private long companyCd; 
	private String companyNm;
	private String filmoNames;
	
	
	/**
	 * @return the companyCd
	 */
	public long getCompanyCd() {
		return companyCd;
	}
	/**
	 * @param companyCd the companyCd to set
	 */
	public void setCompanyCd(long companyCd) {
		this.companyCd = companyCd;
	}
	/**
	 * @return the companyNm
	 */
	public String getCompanyNm() {
		return companyNm;
	}
	/**
	 * @param companyNm the companyNm to set
	 */
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	/**
	 * @return the filmoNames
	 */
	public String getFilmoNames() {
		return filmoNames;
	}
	/**
	 * @param filmoNames the filmoNames to set
	 */
	public void setFilmoNames(String filmoNames) {
		this.filmoNames = filmoNames;
	}

	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyVO [companyCd=").append(companyCd).append(", companyNm=").append(companyNm)
				.append(", filmoNames=").append(filmoNames).append("]");
		return builder.toString();
	}
	
	


	
	
	
	
}//CompanyVO
