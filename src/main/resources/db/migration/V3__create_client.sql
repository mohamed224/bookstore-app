--
-- Structure de la table `client`
--

CREATE TABLE `client` (
                          `id` bigint(20) NOT NULL,
                          `address` varchar(255) DEFAULT NULL,
                          `email` varchar(255) DEFAULT NULL,
                          `first_name` varchar(255) DEFAULT NULL,
                          `last_name` varchar(255) DEFAULT NULL,
                          `password` varchar(255) DEFAULT NULL,
                          `phone_number` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_bfgjs3fem0hmjhvih80158x29` (`email`) USING HASH;

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;
