package io.employed.service.repository

import io.employed.proto.JobProto
import io.employed.proto.UserProto
import org.springframework.stereotype.Repository

@Repository
class JobRepository {
    var jobMap: Map<String, List<JobProto.Job>> = mapOf()

    fun createJobs(user: UserProto.User) {
        val jobList = ArrayList<JobProto.Job>()
        jobList.add(buildJob("Software Engineer", "Need a software engineer with at least 3-5 years of experience.  Tasks" +
                "will include attending daily scrums, wirting code, and being a team player.  Skill needed are the" +
                "following: Java, C++, etc."))
        jobMap = hashMapOf(user.email to jobList)
    }

    fun buildJob(title: String, description: String) : JobProto.Job {
        val jobBuilder = JobProto.Job.newBuilder()

        jobBuilder.setTitle(title)
        jobBuilder.setCatergory(JobProto.Job.CatergoryType.ENGINEERING)
        jobBuilder.setDescription(description)
        jobBuilder.setSalary(50.00)

        jobBuilder.companyBuilder.setDescription("Google company")
        jobBuilder.companyBuilder.setName("Google")

        return jobBuilder.build()
    }
}