<h1>Policy Machine 1.5 - Harmonia</h1>

<h3>Brought to you by the National Institute of Standards and Technology</h3>
<p>This is the<a href = "http://csrc.nist.gov/pm/"> link </a>to our external site for more information about the Policy Machine.</p>

<p><strong>Quick Install Guide:</strong><br>
* Follow these steps to install Harmonia. Uninstall Harmonia if it is already installed on your computer before executing these steps. <br>
  - This quick guide will log you on as one of the sample users - 'bob', which is setup in Harmonia as part of installation. <br>
  - If you want to create other users for different client machines, please go through the installation guide provided in C:\PM\doc\Manuals.
<ol>
  <li> Extract this zip file to the directory of your choice.</li>
  <li> Run Harmonia.exe (Under directory called 'install') file on your computer and follow the instructions. Keep the default installation directory to C: drive.</li>
  <li> Once installed, run server.bat from your desktop to start the server.</li> 
  <li>Once server is started successfully, run super.bat from desktop to run the Admin tool. </li>
  <li>Enter the default password for the keystores is 'aaaaaa' (you can change this password in your super.bat file).</li> 
  <li>Pick keystore under C:\PM\keystores\superKeystore and truststore under C:\PM\keystores\clientTruststore.</li>
  <li>Once Admin tool is up and running, import file C:\PM\conf\PMServerConfiguration.pm using File-->Import menu.</li>
  <li>Start the Simlator.bat from your desktop</li>
  <li>Start session.bat to start the client on your computer. </li>
  <li> At the logon screen enter user/password as bob/bob to logon as Bob. </li>
</ol>
</p>

<p><strong>General Information:</strong><br>
The Policy Machine is an access control mechanism that comprises: (1) Access control data used to express access control policies and deliver capabilities of data services to perform operations on objects; (2) a set of administrative operations for configuring the access control; and (3) a set of functions for enforcing policy on requests to execute operations on objects and for computing access decisions to accommodate or reject those requests based on the current state of the access control data.
What distinguish the Policy Machine from other mechanisms are the data elements and relations that define its access control data, the type of operations that are recognized, and the functions that it implements. These specifics are driven by a redefinition of access control and data services in terms of what is believed to be their common and underlying elements, relations, and functions.</p>

<p><strong>New and special in this release:</strong><br>
This is the first public release of the Policy Machine.</p>

<p><strong>Hardware and software requirements:</strong><br>
This program requires a few external products to be installed on the computer:
See the Installation Guide in the doc folder</p>

<p><strong>Installation instructions, getting started tips, and documentation:</strong><br>
See the Installation Guide in the doc folder</p>

<p><strong>Version history:</strong><br>
Public Release 1.5</p>

<p><strong>Contact information:</strong><br>
You can contact either: <br>
David Ferriolo <br>
Serban Gaverillo <br>
Nikki Keller nicole.keller@nist.gov<br>
Gopi Katwala</p>

<p><strong>Date or copyright date, and other legal information:</strong><br>

In the license there is a copyright. This copyright only applies to those who want to use the software outside of the United States of America. Also the creators would greatly appreciate if they can reference NIST in the product they produce when using the Policy Machine. 
</p>
