# Info

One file, drag and drop on your computer, that blocks almost every porn site in existence.

Go ![here](https://github.com/blocklistproject/Lists) for the full Block List Project. This project is a fork of that project, dedicated to blocking porn only.

# Instructions
Works best on a computer where the user is not technically-competent, and is unable to locate and modify a hosts file (children especially). May work well as a "last-resort" option for one who seeks to drop the habit of porn consumption.

Uses empty IP addresses in a file called "hosts", which the system references when connecting to any website. Any IP address mapped to the IP 0.0.0.0 (either incoming or outgoing) is denied access. This can be performed on any IP address, effectively barring it access, in or out, of a computer.

# Background
I sought to block porn sites on my computer, and share it with family and friends. I worked on this project on my own before finding the Block List project; so I incorporated my porn list into their block list. Their block list is massive (over 1.8 million blocked sites, though I am unsure if there are redundancies with domains/sub-domains both being listed) while mine is small, at only about 5k sites. Unfortunately, hosts files cannot be read with regexes, so for the simplest "brute-force" solution to sneakily blocking porn on a computer, this works.

I found the site tblop.com initially. I searched for similar sites and was intrigued when I found several dozen sites with the exact same HTML layout as tblop (down to class names and indentation structure). Tblop is run by someone named Greg, and it is probable that every other site I found and scraped for links is run by Greg, or someone affiliated with him, as well.
