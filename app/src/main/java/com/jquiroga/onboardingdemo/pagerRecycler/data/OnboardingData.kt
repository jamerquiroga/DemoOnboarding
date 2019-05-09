package com.jquiroga.onboardingdemo.pagerRecycler.data

class OnboardingData{

    fun getDataForOnboarding() : ArrayList<Onboarding>{

        val gaoOnboarding = arrayListOf<Onboarding>()

        gaoOnboarding.add(Onboarding("Titulo 1","Descripción 1", "url1"))
        gaoOnboarding.add(Onboarding("Titulo 2","Descripción 2", "url2"))
        gaoOnboarding.add(Onboarding("Titulo 3","Descripción 3", "url3"))
        gaoOnboarding.add(Onboarding("Titulo 4","Descripción 3", "url3"))
        gaoOnboarding.add(Onboarding("Titulo 5","Descripción 3", "url3"))

        return gaoOnboarding
    }
}

