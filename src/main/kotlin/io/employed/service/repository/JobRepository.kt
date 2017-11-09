package io.employed.service.repository

import io.employed.proto.JobProto
import org.springframework.stereotype.Repository

@Repository
class JobRepository {
    var jobMap: Map<String, List<JobProto.Job>> = mapOf()

    constructor() {
        createJobs()
    }

    fun createJobs() {
        val jobBuilder = JobProto.Job.newBuilder()

        jobBuilder.setTitle("Sofware Engineer")
        jobBuilder.setCatergory(JobProto.Job.CatergoryType.ENGINEERING)
        jobBuilder.setDescription("Need a software engineer with at least 3-5 years of experience.  Tasks" +
                "will include attending daily scrums, wirting code, and being a team player.  Skill needed are the" +
                "following: Java, C++, etc.")

        jobBuilder.companyBuilder.setDescription("Google company")
        jobBuilder.companyBuilder.setName("Google")
    }
}