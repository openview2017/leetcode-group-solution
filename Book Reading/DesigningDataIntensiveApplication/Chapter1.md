# Chapter 1 Reliable, Scalable and Maintainable Applications

## Reliability
> 所谓reliable：  在硬件不靠谱，软件不靠谱，人为失误等情况下，如果保证system能承受一些可以理解的fault，叫 fault tolerant或者resilient。这里说 “可理解的fault”，就是某一个或者两个component了不工作了 但是system能继续 continuely的 correctly的 工作（opposite就是整个system电线被拔了，地球毁灭了，这极端情况不再考虑范围）
> 硬件，软件，人为失误，三个角度去思考 如何避免, 或者发生了如何及时修复
> - Hardware Fault
  >   - what : hard disk crash  
  >   - why: old, too hot(happened in oci), other exceptions
  >   - how to prevent/resolve :
  >       - add redundancy to individual hardware components (备用)
  >       - raid configuration （？）
  >       - servers have dual power supplies
  >       - hot-swappable CPU 
> - Software errors 
  >   - What: Systematic error within the system
  >   - Why :
  >       -  software bug (bad input), 写代码的时候assume good environment
  >       - runaway process that uses up shared resource(CPU time, memory, disk, bandwidth)
  >       - dependency slows down, unresponsive or returning corrupted responses
  >       - Cascading failures, a small fault triggers a fault in another component, then triggers more further faults.
  >   - How to prevent/resolve : no quick solution
  >       - carefully thinking about assumptions，interactions
  >       - testing
  >       - process isolation
  >       - allow process to crash， restart
  >       - measuring， monitoring，analyzing
> - Human Errors
  >   -  What: operations error, abuse system
  >   - Why: human are known to be unreliable 
  >   - How:
  >       - well designed abstraction, APIs, admin interface 控制权限，减少人为可能造成的失误
  >       - Decouple the places people make most mistakes, 提供real data test environment 
  >       - require through test, whole system integration test and manual test. automation test.
  >       - Allow quick and easy recover(fast roll back) , minimize impact in the case of failure (provide tool to re-compute data)
  >       - Monitoring(metrics, error rates) – telemetry

## Scalability
> - Reliable today  → Reliable in the future ? Scalability : 系统 cope up的能力
>   - increased load
>   - increased users
>   - increased data volumes
> - Describing Load 分析负载, 找到bottleneck 
>   - current load， 基于current load，才可以讨论增长
>     - qps : query per second on a web server
>     - read/write ratio in database 
>     - simultaneously active users
>     - hit rate on cache
> - Describing Performance 分析性能，investigate what happens when load increase
>   - increase load parameter，with resources(CPU, memory, bandwidth) unchanged,  how is performance affected
>   - increase load parameter，how much you need to increase the resources to keep performace unchanged 	
>   - 衡量performance
>     - throughput：number of records process per seconds
>     - response time（what client sees）： the time between client sending request and receiving a response ， including network delay， queueing delays
>     - latency： is the duration that a request waiting to be handled
>   - 以上衡量system performance的参数，可能每一次request 都不一样，
>   - 因此 参数并不是一个绝对 独立的数字，我们需要累计一段时间的参数分布来衡量 eg .dashboard
>   - percentile , p95, p99, p999
>   - SLO, SLA(agreement)
> - Approaches for Coping with Load







 




