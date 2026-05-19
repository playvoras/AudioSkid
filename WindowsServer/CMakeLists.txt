cmake_minimum_required(VERSION 3.10)
project(AudioSkidServer)

set(CMAKE_BUILD_TYPE Release)

if(MSVC)
    set(CMAKE_CXX_FLAGS_RELEASE
        "/O2 /Ob3 /Oi /Ot /Oy"
        "/GT /GL /GS- /GF /Gw /Gy"
        "/fp:fast /arch:AVX2 /MT /Qpar"
    )
    set(CMAKE_EXE_LINKER_FLAGS_RELEASE
        "/LTCG /OPT:REF /OPT:ICF /INCREMENTAL:NO"
    )
else()
    set(CMAKE_CXX_FLAGS_RELEASE
        "-Ofast -flto -march=native"
        "-ffast-math -funroll-loops"
        "-fomit-frame-pointer -fno-stack-protector"
        "-fvisibility=hidden -fvectorize -fslp-vectorize"
    )
    set(CMAKE_EXE_LINKER_FLAGS_RELEASE
        "-flto -fuse-ld=lld"
    )
endif()

add_executable(AudioSkidServer
    main.cpp
)

target_link_libraries(AudioSkidServer
    ws2_32
    ole32
    mmdevapi
    avrt
)