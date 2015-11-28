package org.aea.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the family_transfer database table.
 * 
 */
@Entity
@Table(name="family_transfer")
@NamedQuery(name="FamilyTransfer.findAll", query="SELECT f FROM FamilyTransfer f")
public class FamilyTransfer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String indebtness;

	@Column(length=255)
	private String reason;

	@Column(name="return_source")
	private int returnSource;

	@Column(name="to_worksite_name", length=45)
	private String toWorksiteName;

	@Temporal(TemporalType.DATE)
	@Column(name="transfer_date")
	private Date transferDate;

	//bi-directional many-to-one association to Family
	@ManyToOne
	@JoinColumn(name="family")
	private Family familyBean;

	//bi-directional many-to-one association to Ngo
	@ManyToOne
	@JoinColumn(name="from_ngo")
	private Ngo ngo1;

	//bi-directional many-to-one association to Worksite
	@ManyToOne
	@JoinColumn(name="from_worksite")
	private Worksite worksite1;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="to_address")
	private Address address;

	//bi-directional many-to-one association to Ngo
	@ManyToOne
	@JoinColumn(name="to_ngo")
	private Ngo ngo2;

	//bi-directional many-to-one association to Worksite
	@ManyToOne
	@JoinColumn(name="to_worksite")
	private Worksite worksite2;

	//bi-directional many-to-one association to SchoolTransfer
	@OneToMany(mappedBy="familyTransfer", fetch=FetchType.EAGER)
	private Set<SchoolTransfer> schoolTransfers;

	public FamilyTransfer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIndebtness() {
		return this.indebtness;
	}

	public void setIndebtness(String indebtness) {
		this.indebtness = indebtness;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getReturnSource() {
		return this.returnSource;
	}

	public void setReturnSource(int returnSource) {
		this.returnSource = returnSource;
	}

	public String getToWorksiteName() {
		return this.toWorksiteName;
	}

	public void setToWorksiteName(String toWorksiteName) {
		this.toWorksiteName = toWorksiteName;
	}

	public Date getTransferDate() {
		return this.transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public Family getFamilyBean() {
		return this.familyBean;
	}

	public void setFamilyBean(Family familyBean) {
		this.familyBean = familyBean;
	}

	public Ngo getNgo1() {
		return this.ngo1;
	}

	public void setNgo1(Ngo ngo1) {
		this.ngo1 = ngo1;
	}

	public Worksite getWorksite1() {
		return this.worksite1;
	}

	public void setWorksite1(Worksite worksite1) {
		this.worksite1 = worksite1;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Ngo getNgo2() {
		return this.ngo2;
	}

	public void setNgo2(Ngo ngo2) {
		this.ngo2 = ngo2;
	}

	public Worksite getWorksite2() {
		return this.worksite2;
	}

	public void setWorksite2(Worksite worksite2) {
		this.worksite2 = worksite2;
	}

	public Set<SchoolTransfer> getSchoolTransfers() {
		return this.schoolTransfers;
	}

	public void setSchoolTransfers(Set<SchoolTransfer> schoolTransfers) {
		this.schoolTransfers = schoolTransfers;
	}

	public SchoolTransfer addSchoolTransfer(SchoolTransfer schoolTransfer) {
		getSchoolTransfers().add(schoolTransfer);
		schoolTransfer.setFamilyTransfer(this);

		return schoolTransfer;
	}

	public SchoolTransfer removeSchoolTransfer(SchoolTransfer schoolTransfer) {
		getSchoolTransfers().remove(schoolTransfer);
		schoolTransfer.setFamilyTransfer(null);

		return schoolTransfer;
	}

}