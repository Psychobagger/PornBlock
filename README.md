# Info

One file, drag and drop on your computer, that blocks almost 2 million porn sites.

Go ![here](https://github.com/blocklistproject/Lists) for the full Block List Project. This project is a fork of that project, dedicated to blocking porn only.

# Instructions
Works best on a computer where the user is not technically-competent, and is unable to locate and modify a hosts file (children especially). May work well as a "last-resort" option for one who seeks to drop the habit of porn consumption.

* For Windows computers, simply download and place the file, **hosts.txt** (full file ![here](https://anonfiles.com/zfu2y7dcp1/hosts_txt), into **C:\Windows\System32\drivers\etc**; if the file already exists, it is okay to overwrite it, as there is nothing except comments in there by default.
* From an admininstrator account (if you are a parent), right click the hosts file, select Properties and mark the check-box to make it read-only. This way, it cannot be edited except by an administrator (no smart kids editing it).

Uses empty IP addresses in a file called "hosts", which the system references when it gets an IP request. Any IP address mapped to the IP 0.0.0.0 (either incoming or outgoing) is denied access. This can be performed on any IP address, effectively barring it access, in or out, of a computer.

# Technical Stuff
I used Java hashsets all over the place. It made managing redundancies a breeze.

I experimented with my hosts file, and I found that blocking pornhub.com was insufficient, because I was able to type in www.pornhub.com and access the site. Verify this yourself, it's accurate, at least on Windows 10. So for a "full block", I duplicated each URL and prepended it with www., so that every URL shows up twice, once without www. and once with it. Github LFS will not let me upload the full file, since this is a public fork. So, if you want it, get the code working in Eclipse or whatever you use, making sure to add the jsoup library to your classpath, then run Main.java and get the hosts.txt.

Or, go to this ![anonfile link](https://anonfiles.com/zfu2y7dcp1/hosts_txt) and download it. I just found this site as a free file hosting plaform, up to 20GB. I wish I had known about it forever ago.

# Background
I sought to block porn sites on my computer, and share it with family and friends. I worked on this project on my own before finding the Block List project; so I incorporated my porn list into their block list. Their block list is massive (over 1.9 million blocked sites, though I am unsure if there are redundancies with domains/sub-domains both being listed) while mine is small, at only a few thousand sites. Many of the 1.9mil blocked sites seem obscure; the sites I have gathered are not so. Unfortunately, hosts files cannot be read with regexes: so for the simplest "brute-force" solution to sneakily blocking *most* porn on a computer, this works.

I found the site tblop.com initially, through the Google search "top porn sites". I searched for similar sites and was intrigued when I found several dozen sites with the exact same HTML layout as tblop (down to class names, indentation structure and image layout). Tblop is run by someone named Greg, and it is probable that every other site I found and scraped for links is run by Greg, or someone affiliated with him.

Much of the work finding new sites to scrape was simply typing in "top porn sites", or related search terms. I also followed Greg's social media (he has a ton listed on tblop) and found a lot more links therein.

https://www.reddit.com/user/gregfromtblop
https://pastebin.com/u/tblop

Here is the tblop site. This format is redundant across many, many other sites.
![](https://github.com/Psychobagger/PornBlock/blob/master/images/tblop.PNG)

# Sites Crawled
* tblop.com
* toppornsites.com
* bestxxxsites.com
* pornabc.com
* iwantporn.net
* pornwhitelist.com
* bestanalpornsites.com
* pornsites.xxx
* tubepornlist.com
* mature-porn-list.com
* toppornsites.net
* sexpornlist.com
* bestlistofporn.com
* thesexlist.com
* myasiansites.com
* worldpornlist.com
* pornmate.com
* bestyoungpornsites.com
* teenpornsites.org
* bestpornsites.guide
* mypornbible.com
* goodpornsites.com
* mrporngeek.com
* bbwpornsites.org
* listofporn.com
* topblackpornsites.com
* porndabster.com
* bestpornsites.porn
* bestgaypornsites.com
* myporngay.com
* judeporn.com
* bigcamlist.com
* shemalepornsites.net
* bestlatinapornsites.com
* faptogayporn.net
* mypornbookmarks.com
* myporndir.net
* xpornolist.com
* iwantporn.net_gay
* indianpornlist.com
* besttrannypornsites.com
* weknowporn.com
* bigpornlist.com
* japanesesites.porn
* best-adultsites.com
* bestpornamateur.com
* pornoracle.com
* 69pornlist.com
* bigpornlist.net
* nudesquad.com
* maturepornsites.net
* bestmilfsites.com
* mypornfox.com
* primepornlist.com
* thesafeporn.com
* thebestfetishsites.com
* theporndude.com
* allpornsites.net
* bestpornsites.net
* best10.net
* exxxtra.net
* mygaysites.com
* lesbiansites.porn
* hdpornlist.com
* sexhq.com
* sharkyporn.com
* hotporn.today
* toppornsites.porn
* toppornguide.com
* toppornsites.co.uk
* pornplanner.com
* sexpornlist.net
* fivestarpornsites.com
* pornaddik.com
* bestcamsites.net
* besthardcorepornsites.com
* tbpsl.com
* hotpornbible.com
* toplist18.com
* lustylist.com
* thesafeporn.net
* cumshotlist.com
* area51.to
* britpornsites.com
* topamateurpornsites.com
* aulaporn.com
* taboopornsites.com
* zweiporn.com
* freesafeporn.com
* epikporn.top
* pornfinger.com
* best4kpornsites.com
* bioporno.com
* duckgay.com
* deutsche-pornoseiten.com
* bestvirtualpornsites.com
* iwantporn.org
* iwantbestporn.com
