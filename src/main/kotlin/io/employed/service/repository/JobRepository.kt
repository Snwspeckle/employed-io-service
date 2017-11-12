package io.employed.service.repository

import io.employed.proto.Job
import io.employed.proto.User
import org.springframework.stereotype.Repository

@Repository
class JobRepository {

    var jobMap: Map<String, List<Job>> = mapOf()

    val description1 = "Need a software engineer with at least 3-5 years of experience.  Tasks will include attending daily scrums, writing code, and being a team player.  Skill needed are the following: Java, C++, etc."
    val description2 = "Need a software engineer with at least 3-5 years of experience.  Tasks will include attending daily scrums, writing code, and being a team player.  Skill needed are the following: Java, C++, etc."
    val description3 = "Need a software engineer with at least 1-2 years of experience.  Tasks will include attending daily scrums, writing code, and being a team player.  Skill needed are the following: Java, C++, etc."

    val responsibilities1 = "Tasks will include attending daily scrums, writing code, and being a team player"
    val responsibilities2 = "Tasks will include attending daily scrums, writing code, and being a team player"
    val responsibilities3 = "Tasks will include attending daily scrums, writing code, and being a team player"

    val requirements1 = "B.S. in computer science or related field or equivalent professional experience;Experience with the JVM and JVM based languages such as Java, Scala or Clojure;Excellent communication skills, both verbal and written;Experience with the Lightbend stack (Scala, Play, Akka) strongly preferred"
    val requirements2 = "Experience in functional programming languages and methodologies such as Scala;Haskell, Clojure, or F# preferred, Experience with HTML, JavaScript, CSS, AJAX;Knowledge of Git and GitHub;Knowledge of ReactJS or similar JavaScript frameworks preferred"
    val requirements3 = "Self-motivated, eager to learn, and team-oriented;Ability to work independently with minimal oversight;A scientific background is a plus, but not required;Strong communication and social skills"

    val experience1 = "3-5 years in a CS field or equivalent"
    val experience2 = "5-10 years in a CS field or equivalent"
    val experience3 = "1-2 years in a CS field or equivalent"

    fun createJobs(user: User) {
        val jobList = ArrayList<Job>()
        jobList.add(buildJob("Software Engineer", description1, responsibilities1, requirements1, experience1))
        jobList.add(buildJob("Senior Software Engineer", description2, responsibilities2, requirements2, experience2))
        jobList.add(buildJob("Junior Software Engineer", description3, responsibilities3, requirements3, experience3))
        jobMap = hashMapOf(user.email to jobList)
    }

    fun buildJob(title: String, description: String, responsibilities: String, requirements: String, experience: String) : Job {
        val jobBuilder = Job.newBuilder()

        jobBuilder.setTitle(title)
        jobBuilder.setCatergory(Job.CatergoryType.ENGINEERING)
        jobBuilder.setDescription(description)
        jobBuilder.setResponsibilities(responsibilities)
        jobBuilder.setRequirements(requirements)
        jobBuilder.setExperience(experience)
        jobBuilder.setSalary(50.00)

        jobBuilder.addressBuilder.setCity("Cincinnati")
        jobBuilder.addressBuilder.setState("Ohio")
        jobBuilder.addressBuilder.setCountry("USA")

        jobBuilder.recruiterBuilder.setCompany("E-Corp")
        jobBuilder.recruiterBuilder.nameBuilder.setFirstName("Angela")
        jobBuilder.recruiterBuilder.nameBuilder.setLastName("Moss")

        jobBuilder.companyBuilder.setDescription("E-Corp Bank")
        jobBuilder.companyBuilder.setName("E-Corp")

        return jobBuilder.build()
    }
}