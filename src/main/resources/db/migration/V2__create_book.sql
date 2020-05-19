CREATE TABLE `book` (
                        `id` bigint(20) NOT NULL,
                        `author` varchar(255) DEFAULT NULL,
                        `available` bit(1) NOT NULL,
                        `description` varchar(255) DEFAULT NULL,
                        `name` varchar(255) DEFAULT NULL,
                        `pic_byte` tinyblob DEFAULT NULL,
                        `price` double NOT NULL,
                        `quantity` int(11) NOT NULL,
                        `category_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `book`
--
ALTER TABLE `book`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKam9riv8y6rjwkua1gapdfew4j` (`category_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `book`
--
ALTER TABLE `book`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;
