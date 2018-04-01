package io.employed.service.persistence

import io.employed.proto.Address
import io.employed.proto.Company
import io.employed.proto.Industry
import io.employed.proto.Job
import io.employed.proto.Location
import io.employed.proto.Recruiter
import org.springframework.cassandra.core.PrimaryKeyType
import org.springframework.data.cassandra.mapping.Column
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.mapping.Table
import java.util.UUID

@Table(value = "jobs")
data class JobEntity(
    @PrimaryKeyColumn(name = "job_id", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    val jobId: UUID,

    @Column
    val title: String,

    @Column
    val description: String,

    @Column(value = "short_description")
    val shortDescription: String,

    @Column(value = "company_id")
    val companyId: UUID,

    @Column(value = "company_name")
    val companyName: String,

    @Column(value = "company_avatar_url")
    val companyAvatarUrl: String,

    @Column(value = "recruiter_id")
    val recruiterId: UUID,

    @Column(value = "recruiter_first_name")
    val recruiterFirstName: String,

    @Column(value = "recruiter_last_name")
    val recruiterLastName: String,

    @Column
    val industry: String,

    @Column(value = "employment_type")
    val employmentType: String,

    @Column
    val salary: Int,

    @Column(value = "min_salary")
    val minSalary: Int,

    @Column(value = "max_salary")
    val maxSalary: Int,

    @Column
    val latitude: Double,

    @Column
    val longitude: Double,

    @Column(value = "street_address")
    val streetAddress: String,

    @Column
    val city: String,

    @Column
    val state: String,

    @Column
    val country: String,

    @Column
    val zip: String,

    @Column(value = "number_of_hires")
    val numberOfHires: Int,

    @Column(value = "required_experience")
    val requiredExperience: String,

    @Column(value = "preferred_experience")
    val preferredExperience: String,

    @Column
    val responsibilities: String,

    @Column
    val experience: Int,

    @Column(value = "education_level")
    val educationLevel: List<String>,

    @Column
    val skills: List<String>,

    @Column
    val tags: List<String>
)

fun JobEntity.toProto(): Job {
    val job = Job.newBuilder()
        .setJobId(jobId.toString())
        .setTitle(title)
        .setDescription(description)
        .setShortDescription(shortDescription)
        .setCompany(Company.newBuilder()
            .setCompanyId(companyId.toString())
            .setName(companyName)
            .setAvatarUrl(companyAvatarUrl)
        ).setRecruiter(Recruiter.newBuilder()
            .setUserId(recruiterId.toString())
            .setFirstName(recruiterFirstName)
            .setLastName(recruiterLastName)
        ).setIndustry(Industry.valueOf(industry))
        .setEmploymentType(Job.EmploymentType.valueOf(employmentType))
        .setLocation(Location.newBuilder()
            .setLatitude(latitude)
            .setLatitude(longitude)
            .setAddress(Address.newBuilder()
                .setStreetAddress(streetAddress)
                .setCity(city)
                .setState(state)
                .setCountry(country)
                .setZip(zip)
            )
        ).setNumberOfHires(numberOfHires)
        .setRequiredExperience(requiredExperience)
        .setPreferredExperience(preferredExperience)
        .addAllSkills(skills)
        .setResponsibilities(responsibilities)
        .setExperience(experience)
        .addAllEducationLevel(educationLevel.map { Job.EducationLevel.valueOf(it) })
        .addAllTags(tags)

    return when {
        minSalary > 0 && maxSalary > 0 -> job.setSalaryRange(Job.SalaryRange.newBuilder().setMinSalary(minSalary).setMaxSalary(maxSalary))
        else -> job.setSalary(salary)
    }.build()
}

fun Job.toEntity(jobUUID: UUID? = null, companyUUID: UUID? = null): JobEntity = JobEntity(jobUUID?.let { it } ?: UUID.fromString(jobId),
    title,
    description,
    shortDescription,
    companyUUID?.let { it } ?: UUID.fromString(company.companyId),
    company.name,
    company.avatarUrl,
    UUID.fromString(recruiter.userId),
    recruiter.firstName,
    recruiter.lastName,
    industry.name,
    employmentType.name,
    salary,
    salaryRange.minSalary,
    salaryRange.maxSalary,
    location.latitude,
    location.longitude,
    location.address.streetAddress,
    location.address.city,
    location.address.state,
    location.address.country,
    location.address.zip,
    numberOfHires,
    requiredExperience,
    preferredExperience,
    responsibilities,
    experience,
    educationLevelList.map { it.name },
    skillsList,
    tagsList
)